package com.sebashc.centrovacacional.gimnasio.app;

import com.sebashc.centrovacacional.gimnasio.app.models.documents.Plan;
import com.sebashc.centrovacacional.gimnasio.app.services.PlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GimnasioApplicationTests {
	@Autowired
	private WebTestClient client;

	@Autowired
	private PlanService service;

	@Test
	void mostrarPlanesTest() {
		client.get()
				.uri("/gimnasio/mostrarPlanes")
				.accept(MediaType.APPLICATION_JSON).exchange()
				.expectStatus().isOk().expectHeader()
				.contentType(MediaType.APPLICATION_JSON)
				.expectBodyList(Plan.class).hasSize(3);
	}

	@Test
	void verPlanTest() {
		Plan plan = service.findById("637401dafee68f05bed605be").block();

		client.get()
				.uri("gimnasio/verPlan/{id}", Collections.singletonMap("id", plan.getId()))
				.accept(MediaType.APPLICATION_JSON).exchange()
				.expectStatus().isOk().expectHeader()
				.contentType(MediaType.APPLICATION_JSON).expectBody()
				.jsonPath("$.id").isNotEmpty();
	}

	@Test
	void guardarPlanTest() {
		Plan plan = new Plan("Plan Amigos", new BigDecimal(200000), "Plan de maximo 4 personas");

		client.post().uri("/gimnasio/guardarPlan")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(plan), Plan.class).exchange()
				.expectStatus().isCreated()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody().jsonPath("$.id").isNotEmpty()
				.jsonPath("$.nombre").isEqualTo("Plan Amigos")
				.jsonPath("$.descripcion").isEqualTo("Plan de maximo 4 personas");
	}

	@Test
	void editarPlanTest() {
		Plan plan = service.findById("636e7929b7205abcdb051b80").block();
		Plan planEditado = new Plan("Plan Amigos", new BigDecimal(200000), "Plan de maximo 4 personas");

		client.put()
				.uri("gimnasio/actualizarPlan/{id}", Collections.singletonMap("id", plan.getId()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(planEditado), Plan.class).exchange()
				.expectStatus().isCreated()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody().jsonPath("$.id").isNotEmpty()
				.jsonPath("$.nombre").isEqualTo("Plan Amigos")
				.jsonPath("$.precio").isEqualTo(200000)
				.jsonPath("$.descripcion").isEqualTo("Plan de maximo 4 personas");
	}

	@Test
	void eliminarPlan() {
		Plan plan = service.findById("63740b650167d84ac6dd376a").block();

		client.delete()
				.uri("gimnasio/eliminarPlan/{id}", Collections.singletonMap("id", plan.getId()))
				.exchange().expectStatus().isNoContent().expectBody().isEmpty();

		// Verificar si se borro el plan
		client.get()
				.uri("gimnasio/verPlan/{id}", Collections.singletonMap("id", plan.getId()))
				.exchange().expectStatus().isNotFound().expectBody().isEmpty();
	}
}
