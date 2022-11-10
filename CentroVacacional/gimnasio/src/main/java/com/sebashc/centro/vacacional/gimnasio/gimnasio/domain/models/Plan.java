package com.sebashc.centro.vacacional.gimnasio.gimnasio.domain.models;

import java.math.BigDecimal;

// Importar dependencias de mongo para el documento
public class Plan {
    private String codigo;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    /*

    create database if not exists gimnasio2 character set utf8 collate utf8_general_ci;
use gimnasio2;

create table if not exists distrito(
	nombre varchar(100) not null primary key
)engine=innodb;

create table if not exists gimnasio(
	codigo int not null primary key,
    nombre varchar(100) not null,
    telefono int not null,
    direccion varchar(100) not null,
    nombre_distrito varchar(100) not null,
    foreign key fk_nom_dist(nombre_distrito) references distrito(nombre)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists promocion(
	codigo int not null primary key,
    nombre varchar(100) not null,
    descripcion text(2000),
    descuento int not null,
    fecha_ini date not null,
    fecha_fin date not null
)engine=innodb;

create table if not exists persona(
	dni int not null primary key,
    nombre varchar(100) not null,
    direccion varchar(100) not null,
    telefono int not null,
    correo varchar(100),
    fecha_nacimiento date not null,
    sexo varchar(1),
    codigo_gimnasio int not null
)engine=innodb;

create table if not exists cliente(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references persona(dni)
    on update cascade on delete cascade,
    fecha_ini date not null,
    fecha_fin date not null,
    ocupacion varchar(50),
    telefono_emergencia int not null,
    codigo_plan int not null,
    foreign key fk_cod_plan(codigo_plan) references plan(codigo)
    on update cascade on delete cascade,
    codigo_promocion int,
    foreign key fk_cod_pro(codigo_promocion) references promocion(codigo)
    on update cascade on delete cascade,
    num_boleta int not null
)engine=innodb;

create table if not exists tecnico(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references persona(dni)
    on update cascade on delete cascade,
    empresa_asoc varchar(100)
)engine=innodb;

create table if not exists ListaCosas(
	codigo int not null primary key,
    nombre varchar(120) not null

)engine=innodb;

create table if not exists bienesPropios(
	codigoBien int not null primary key,
    codigoLista int not null,
    foreign key fk_cod_lista(codigoLista) references ListaCosas(codigo)
    on update cascade on delete cascade,
    num_boleta int not null,
    codigo_gimnasio int not null,
    foreign key fk_cod_bgim(codigo_gimnasio) references gimnasio(codigo)
    on update cascade on delete cascade,
    precioEstimado int
)engine=innodb;

create table if not exists maquina(
	codigo int not null primary key,
    foreign key fk_cod_maq(codigo) references bienesPropios(codigoBien)
    on update cascade on delete cascade,
    marca varchar(20),
    modelo varchar(20)
)engine=innodb;

create table if not exists mantenimiento(
	dni_tecnico int not null,
    foreign key fk_mant_tec(dni_tecnico) references tecnico(dni)
    on update cascade on delete cascade,
    codigo_maquina int not null,
    foreign key fk_mant_maq(codigo_maquina) references maquina(codigo)
    on update cascade on delete cascade,
    fecha date not null,
    hora_ini time not null,
    hora_fin time not null,
    primary key (`dni_tecnico`, `codigo_maquina`)
)engine=innodb;

create table if not exists articulo_deportivo(
	codigo int not null primary key,
    foreign key fk_cod_art(codigo) references bienesPropios(codigoBien)
    on update cascade on delete cascade
)engine=innodb;
create table if not exists bienes_gimnasio(
	codigo int not null primary key,
    foreign key fk_cod_bie(codigo) references bienesPropios(codigoBien)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists areas(
	codigo int not null primary key,
    nombre varchar(100) not null,
    piso int not null,
    capacidad int not null,
    codigo_gimnasio int not null,
    foreign key fk_cod_gimnasio(codigo_gimnasio) references gimnasio(codigo)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists evento(
	codigo int not null primary key,
    nombre varchar(100) not null,
    descripcion text(2000) not null,
    fecha_ini date not null,
    fecha_fin date not null,
    hora_ini time not null,
    hora_fin time not null,
    costo_entrada int not null,
    presupuesto int not null,
    codigo_gimnasio int not null,
    foreign key fk_cod_gim(codigo_gimnasio) references gimnasio(codigo)
    on update cascade on delete cascade,
    codigo_areas int not null,
    foreign key fk_cod_sal(codigo_areas) references areas(codigo)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists empleado(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references persona(dni)
    on update cascade on delete cascade,
    sueldo double not null
)engine=innodb;

create table if not exists trabaja(
	dni_empleado int not null,
    codigo_area int not null
)engine=innodb;
alter table trabaja add constraint PK_TRABAJA PRIMARY KEY(dni_empleado,codigo_area);
alter table trabaja add constraint CO_EMPLEADO FOREIGN KEY FK_EMPLEADO(dni_empleado) REFERENCES empleado(dni) on delete cascade on update cascade;
alter table trabaja add constraint CO_AREA FOREIGN KEY FK_AREA(codigo_area) REFERENCES areas(codigo) on delete cascade on update cascade;

create table if not exists dias_trabaja(
	dni_empleado int not null,
    foreign key fk_dni_empleado(dni_empleado) references trabaja(dni_empleado)
    on update cascade on delete cascade,
    dia varchar(20) not null,
    hora_ini time not null,
    hora_fin time not null
)engine=innodb;
alter table dias_trabaja add constraint PK_HORARIO PRIMARY KEY(dni_empleado,dia);

create table if not exists instructor(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references empleado(dni)
    on update cascade on delete cascade,
    curso varchar(20) not null
)engine=innodb;

create table if not exists entrenador(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references empleado(dni)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists nutricionista(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references empleado(dni)
    on update cascade on delete cascade,
    colegiatura varchar(20)
)engine=innodb;

create table if not exists enc_limpieza(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references empleado(dni)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists recepcionista(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references empleado(dni)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists fisioterapeuta(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references empleado(dni)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists asesor(
	dni int not null primary key,
    foreign key fk_dni_empleado(dni) references empleado(dni)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists fichaMedica(
	codigo int not null primary key,
    fecha date not null,
    peso int not null,
    talla int not null,
    med_cintura int not null,
    med_cadera int not null,
    med_cuello int not null,
    porc_grasa_corporal int not null,
    masa_corp_magra  int not null,
    objetivo varchar(500) not null,
    dni_nutricionista int not null,
    foreign key fk_dni_nutricionista(dni_nutricionista) references nutricionista(dni)
    on update cascade on delete cascade,
    dni_cliente int not null,
    foreign key fk_dni_cliente(dni_cliente) references cliente(dni)
    on update cascade on delete cascade
)engine=innodb;

create table if not exists vacunas_ficha(
	codigo_ficha int not null primary key,
    foreign key fk_codigo_ficha_medica(codigo_ficha) references fichaMedica(codigo)
    on update cascade on delete cascade,
    vacuna varchar(30) not null
)engine=innodb;

create table if not exists operaciones_ficha(
	codigo_ficha int not null primary key,
    foreign key fk_codigo_ficha_medica(codigo_ficha) references fichaMedica(codigo)
    on update cascade on delete cascade,
    operacion varchar(30) not null
)engine=innodb;

create table if not exists enfermedades_ficha(
	codigo_ficha int not null primary key,
    foreign key fk_codigo_ficha_medica(codigo_ficha) references fichaMedica(codigo)
    on update cascade on delete cascade,
    enfermedad varchar(30) not null
)engine=innodb;

create table if not exists invitado_especial(
	dni int not null primary key,
    foreign key fk_dni_invitado_especial(dni) references persona(dni)
    on update cascade on delete cascade,
    ocupacion varchar(100) not null,
    tarifa_hora int not null
)engine=innodb;

create table if not exists participa(
	dni_invitado int not null primary key,
    foreign key fk_dni_invi(dni_invitado) references invitado_especial(dni)
    on update cascade on delete cascade,
    codigo_evento int not null,
    foreign key fk_codigo_evento(codigo_evento) references evento(codigo)
    on update cascade on delete cascade
)engine=innodb;

     */
}
