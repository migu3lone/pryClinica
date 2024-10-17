<?php

require 'database.php';

class daoCita {
    function __construct() {

    }

    public static function getAll() {
        $sql = "SELECT IdCita, concat_ws(', ',paciente.Apellidos,paciente.Nombres) as paciente, especialidad.Especialidad as fk_Especialidad, concat_ws(', ',medico.Apellidos,medico.Nombres) as fk_Medico, Fecha, Hora, fk_Paciente
from cita inner join paciente on cita.fk_Paciente=paciente.IdPaciente
inner join especialidad on cita.fk_Especialidad=especialidad.IdEspecialidad
inner join medico on cita.fk_Medico=medico.IdMedico
ORDER BY IdCita ASC";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $stmt->execute();
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Error en la consulta a la base de datos: " . $e->getMessage());
            return false;
        }
    }

    public static function getById($var1) {
        $sql = "SELECT IdCita, concat_ws(' ',paciente.Nombres,paciente.Apellidos) as fk_Paciente, especialidad.Especialidad as fk_Especialidad, concat_ws(' ',medico.Nombres,medico.Apellidos) as fk_Medico, Fecha, Hora
from cita inner join paciente on cita.fk_Paciente=paciente.IdPaciente
inner join especialidad on cita.fk_Especialidad=especialidad.IdEspecialidad
inner join medico on cita.fk_Medico=medico.IdMedico
where IdCita like ?";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $stmt->execute([$var1]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Error en la consulta a la base de datos: " . $e->getMessage());
            return false;
        }
    }
	
	public static function getByValue($var2, $var3, $var4) {
        $sql = "SELECT IdCita, concat_ws(', ',paciente.Apellidos,paciente.Nombres) as paciente, especialidad.Especialidad as fk_Especialidad, concat_ws(', ',medico.Apellidos,medico.Nombres) as fk_Medico, Fecha, Hora, fk_Paciente
from cita inner join paciente on cita.fk_Paciente=paciente.IdPaciente
inner join especialidad on cita.fk_Especialidad=especialidad.IdEspecialidad
inner join medico on cita.fk_Medico=medico.IdMedico
where especialidad.Especialidad like ? or fk_Medico like ? or fk_Paciente like ?
ORDER BY IdCita ASC";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $param1 = "%" . $var2 . "%";
            $param2 = "%" . $var3 . "%";
			$param3 = "%" . $var4 . "%";
            $stmt->execute([$param1, $param2, $param3]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Ningún ID encontrado:" . $e->getMessage());
            return false;
        }
    }
	
/*	public static function getByValue($var2, $var3) {
        $sql = "SELECT IdCita, concat_ws(', ',paciente.Apellidos,paciente.Nombres) as paciente, especialidad.Especialidad as fk_Especialidad, concat_ws(', ',medico.Apellidos,medico.Nombres) as fk_Medico, Fecha, Hora, fk_Paciente
from cita inner join paciente on cita.fk_Paciente=paciente.IdPaciente
inner join especialidad on cita.fk_Especialidad=especialidad.IdEspecialidad
inner join medico on cita.fk_Medico=medico.IdMedico
where especialidad.Especialidad like ? or fk_Medico like ?
ORDER BY IdCita ASC";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $param1 = "%" . $var2 . "%";
            $param2 = "%" . $var3 . "%";
            $stmt->execute([$param1, $param2]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Ningún ID encontrado:" . $e->getMessage());
            return false;
        }
    }

    /*public static function getByValue($var2) {
        $sql = "SELECT IdCita, concat_ws(', ',paciente.Apellidos,paciente.Nombres) as paciente, especialidad.Especialidad as fk_Especialidad, concat_ws(', ',medico.Apellidos,medico.Nombres) as fk_Medico, Fecha, Hora, fk_Paciente
from cita inner join paciente on cita.fk_Paciente=paciente.IdPaciente
inner join especialidad on cita.fk_Especialidad=especialidad.IdEspecialidad
inner join medico on cita.fk_Medico=medico.IdMedico
where especialidad.Especialidad like ? or fk_Medico like ?
ORDER BY IdCita ASC";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $param = "%" . $var2 . "%";
            $stmt->execute([$param]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Ningún ID encontrado:" . $e->getMessage());
            return false;
        }
    }*/
	

    public static function update($var1, $var2, $var3, $var4, $var5, $var6) {
        //call actCita("C001", "P005", "E001", "M002", "2028-08-05", "08:11:33.000000");
        $sql = "call actCita(?, ?, ?, ?, ?, ?)";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $state = $stmt->execute([$var1, $var2, $var3, $var4, $var5, $var6]);
            return $state;
        } catch (PDOException $e) {
            error_log("Error al intentar actualizar la base de datos: " . $e->getMessage());
            return false;
        }
    }

    public static function insert($var2, $var3, $var4, $var5, $var6) {
        //call agrCita("P001", "E001", "M001", "2025-08-05", "08:11:33.000000");
        $sql = "call agrCita(?, ?, ?, ?, ?)";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $state = $stmt->execute([$var2, $var3, $var4, $var5, $var6]);
            return $state;
        } catch (PDOException $e) {
            error_log("Error al intentar insertar en la base de datos: " . $e->getMessage());
            return false;
        }
    }

    public static function delete($var1) {
        $sql = "DELETE FROM cita WHERE IdCita=?";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $state = $stmt->execute([$var1]);
            return $state;
        } catch (PDOException $e) {
            error_log("Error al intentar eliminar en la base de datos: " . $e->getMessage());
            return false;
        }
    }
}

?>
