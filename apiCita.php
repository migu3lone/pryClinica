<?php

$dao = 'daoCita';
$var1 = 'IdCita';
$var2 = 'fk_Paciente';
$var3 = 'fk_Especialidad';
$var4 = 'fk_Medico';
$var5 = 'Fecha';
$var6 = 'Hora';

/*$dao = 'daoCita';
$var1 = 'var1';
$var2 = 'var2';
$var3 = 'var3';
$var4 = 'var4';
$var5 = 'var5';
$var6 = 'var6';*/

header('Content-Type: application/json');

require 'daoCita.php';

$requestMethod = $_SERVER['REQUEST_METHOD'];

switch($requestMethod) {
    case 'GET':
        handleGetRequest();
        break;
    case 'POST':
        handlePostRequest();
        break;
    case 'DELETE':
        handleDeleteRequest();
        break;
    default:
        echo json_encode([
            "status" => 405,
            "message" => "Método no permitido"
        ]);
        break;
}

function handleGetRequest() {
    global $dao, $var1;

    if (isset($_GET[$var1])) { // $_GET['Id']
        $var1x = $_GET[$var1]; // $_GET['Id']

    //if (isset($input[$var1])) {
    //    $var1x = $input[$var1];

        $result = $dao::getById($var1x);

        if ($result) {
            echo json_encode([
                "status" => 1,
                "data" => $result
            ]);
        } else {
            echo json_encode([
                "status" => 2,
                "message" => "ID no existe"
            ]);
        }
    } else {
        $result = $dao::getAll();

        if ($result) {
            echo json_encode([
                "status" => 1,
                "data" => $result
            ]);
        } else {
            echo json_encode([
                "status" => 2,
                "message" => "Ha ocurrido un error"
            ]);
        }
    }
}

function handlePostRequest() {
    global $dao, $var1, $var2, $var3, $var4, $var5, $var6;

    $input = json_decode(file_get_contents('php://input'), true);

    if (isset($input[$var1]) && isset($input[$var2]) && isset($input[$var3]) && isset($input[$var4]) && isset($input[$var5]) && isset($input[$var6])) {
        $var1x = $input[$var1];
        $var2x = $input[$var2];
        $var3x = $input[$var3];
        $var4x = $input[$var4];
		$var5x = $input[$var5];
		$var6x = $input[$var6];

        // Verificar si existe el ID para decidir entre inserción o actualización
        if (!empty($dao::getIdById($var1x))) {

            // Si el ID existe, actualizar
            $result = $dao::update($var1x, $var2x, $var3x, $var4x, $var5x, $var6x);

            if ($result) {
                echo json_encode([
                    "status" => 1,
                    "message" => "Actualización exitosa"
                ]);
            } else {
                echo json_encode([
                    "status" => 2,
                    "message" => "No se pudo actualizar"
                ]);
            }
        } else {
            // Si el ID no existe, insertar
            $result = $dao::insert($var2x, $var3x, $var4x, $var5x, $var6x);

            if ($result) {
                echo json_encode([
                    "status" => 1,
                    "message" => "Inserción exitosa"
                ]);
            } else {
                echo json_encode([
                    "status" => 2,
                    "message" => "No se pudo insertar"
                ]);
            }
        }
    } else {
        echo json_encode([
            "status" => 2,
            "message" => "Datos incompletos"
        ]);
    }
}

function handleDeleteRequest() {
    global $dao, $var1;

    if (isset($_GET[$var1])) {
        $var1x = $_GET[$var1];

		// Verificar si existe el ID
        if (!empty($dao::getIdById($var1x))) {

            // Si el ID existe, eliminar
		    $result = $dao::delete($var1x);

            if ($result) {
                echo json_encode([
                    "status" => 1,
                    "message" => "Eliminación exitosa"
                ]);
            } else {
                echo json_encode([
                    "status" => 2,
                    "message" => "No se pudo eliminar"
                ]);
            }
        } else {
			// Si el ID no existe
            echo json_encode([
                "status" => 2,
                "message" => "ID no existe"
            ]);
	    }
	} else {
        echo json_encode([
            "status" => 2,
            "message" => "ID no proporcionado"
        ]);
    }
}
?>
