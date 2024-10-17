use bdClinica;
drop procedure if exists actCita;
create procedure actCita
(xIdCita varchar(4), xfk_Paciente varchar(4), xfk_Especialidad varchar(4), xfk_Medico varchar(4), xFecha date, xHora time(6))
update Cita set fk_Paciente=xfk_Paciente, fk_Especialidad=xfk_Especialidad, fk_Medico=xfk_Medico, Fecha=xFecha, Hora=xHora where IdCita=xIdCita;

drop procedure if exists agrCita;
DELIMITER //
create procedure agrCita
(fk_Paciente varchar(4), fk_Especialidad varchar(4), fk_Medico varchar(4), Fecha date, Hora time(6))
begin
declare id varchar(4);
declare cuenta int;
select right(max(IdCita),3)+1 into cuenta from Cita;
set id=concat('C',lpad(cuenta,3,'0'));
insert into Cita values(id, fk_Paciente, fk_Especialidad, fk_Medico, Fecha, Hora);
end //
DELIMITER ;


drop procedure if exists actEspecialidad;
create procedure actEspecialidad
(xIdEspecialidad varchar(4), xEspecialidad varchar(75))
update especialidad set Especialidad=xEspecialidad where IdEspecialidad=xIdEspecialidad;

drop procedure if exists agrEspecialidad;
DELIMITER //
create procedure agrEspecialidad
(Especialidad varchar(75))
begin
declare id varchar(4);
declare cuenta int;
select right(max(IdEspecialidad),3)+1 into cuenta from especialidad;
set id=concat('E',lpad(cuenta,3,'0'));
insert into especialidad values(id, Especialidad);
end //
DELIMITER ;


drop procedure if exists actEspmed;
create procedure actEspmed
(xIdEspmed varchar(4), xfk_Especialidad varchar(4), xfk_Medico varchar(4))
update espmed set fk_Especialidad=xfk_Especialidad, fk_Medico=xfk_Medico where IdEspmed=xIdEspmed;

drop procedure if exists agrEspmed;
DELIMITER //
create procedure agrEspmed
(fk_Especialidad varchar(4), fk_Medico varchar(4))
begin
declare id varchar(4);
declare cuenta int;
select right(max(IdEspmed),3)+1 into cuenta from espmed;
set id=concat('X',lpad(cuenta,3,'0'));
insert into espmed values(id, fk_Especialidad, fk_Medico);
end //
DELIMITER ;


drop procedure if exists actMedico;
create procedure actMedico
(xIdMedico varchar(4), xApellidos varchar(75), xNombres varchar(75), xDNI int(8), xCMP varchar(6), xDireccion varchar(150), xCelular int(9))
update medico set Apellidos=xApellidos, Nombres=xNombres, DNI=xDNI, CMP=xCMP, Direccion=xDireccion, Celular=xCelular where IdMedico=xIdMedico;

drop procedure if exists agrMedico;
DELIMITER //
create procedure agrMedico
(Apellidos varchar(75), Nombres varchar(75), DNI int(8), CMP varchar(6), Direccion varchar(150), Celular int(9))
begin
declare id varchar(4);
declare cuenta int;
select right(max(IdMedico),3)+1 into cuenta from medico;
set id=concat('M',lpad(cuenta,3,'0'));
insert into medico values(id, Apellidos, Nombres, DNI, CMP, Direccion, Celular);
end //
DELIMITER ;


drop procedure if exists actPaciente;
create procedure actPaciente
(xIdPaciente varchar(4), xApellidos varchar(75), xNombres varchar(75), xDNI int(8), xSexo varchar(1), xNacimiento date, xCorreo varchar(75), xDireccion varchar(150), xCelular int(9))
update paciente set Apellidos=xApellidos, Nombres=xNombres, DNI=xDNI, Sexo=xSexo, Nacimiento=xNacimiento, Correo=xCorreo, Direccion=xDireccion, Celular=xCelular where IdPaciente=xIdPaciente;

drop procedure if exists agrPaciente;
DELIMITER //
create procedure agrPaciente
(Apellidos varchar(75), Nombres varchar(75), DNI int(8), Sexo varchar(1), Nacimiento date, Correo varchar(75), Direccion varchar(150), Celular int(9))
begin
declare id varchar(4);
declare cuenta int;
select right(max(IdPaciente),3)+1 into cuenta from paciente;
set id=concat('P',lpad(cuenta,3,'0'));
insert into paciente values(id, Apellidos, Nombres, DNI, Sexo, Nacimiento, Correo, Direccion, Celular);
end //
DELIMITER ;


drop procedure if exists actUsuario;
create procedure actUsuario
(xIdUsuario varchar(4), xApellidos varchar(75), xNombres varchar(75), xCorreo varchar(75), xClave varchar(32), xRol varchar(75))
update usuario set Apellidos=xApellidos, Nombres=xNombres, Correo=xCorreo, Clave=xClave, Rol=xRol where IdUsuario=xIdUsuario;

drop procedure if exists agrUsuario;
DELIMITER //
create procedure agrUsuario
(Apellidos varchar(75), Nombres varchar(75), Correo varchar(75), Clave varchar(32), Rol varchar(75))
begin
declare id varchar(4);
declare cuenta int;
select right(max(IdUsuario),3)+1 into cuenta from usuario;
set id=concat('U',lpad(cuenta,3,'0'));
insert into usuario values(id, Apellidos, Nombres, Correo, Clave, Rol);
end //
DELIMITER ;
