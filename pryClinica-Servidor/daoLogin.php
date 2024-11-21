<?php

require 'database.php';

class daoLogin {
    function __construct() {

    }
	
	public static function getMedicoByIdAndPassword($id, $password) {
        $sql = "SELECT * FROM medico WHERE idMedico = ? AND Password = ?";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $stmt->execute([$id, $password]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Ningún ID encontrado:" . $e->getMessage());
            return false;
        }
    }

	public static function getPacienteByIdAndPassword($id, $password) {
        $sql = "SELECT * FROM paciente WHERE idPaciente = ? AND Password = ?";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $stmt->execute([$id, $password]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Ningún ID encontrado:" . $e->getMessage());
            return false;
        }
    }

	public static function getUsuarioByIdAndPassword($id, $password) {
        $sql = "SELECT * FROM usuario WHERE idUsuario = ? AND Password = ?";

        try {
            $stmt = Database::getInstance()->getDb()->prepare($sql);
            $stmt->execute([$id, $password]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            error_log("Ningún ID encontrado:" . $e->getMessage());
            return false;
        }
    }

	/*
    public static function getUsuarioByIdAndPassword($id, $password) {
        $conn = (new Database())->getInstance();
        $query = "SELECT * FROM usuario WHERE idUsuario = :id AND Password = :password";
        $stmt = $conn->prepare($query);
        $stmt->bindParam(':id', $id);
        $stmt->bindParam(':password', $password);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }*/
}

?>
