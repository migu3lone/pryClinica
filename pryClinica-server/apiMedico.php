<?php

/*$dao = 'daoMedico';
$var1 = 'IdMedico';
$var2 = 'Password';
$var3 = 'Apellidos';
$var4 = 'Nombres';
$var5 = 'DNI';
$var6 = 'CMP';
$var7 = 'Direccion';
$var8 = 'Celular';*/

$dao = 'daoMedico';
$var1 = 'var1';
$var2 = 'var2';
$var3 = 'var3';
$var4 = 'var4';
$var5 = 'var5';
$var6 = 'var6';
$var7 = 'var7';
$var8 = 'var8';

header('Content-Type: application/json');
require 'daoMedico.php';
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
    global $dao, $var1, $var2, $var3;

    if (isset($_GET[$var1])) {
        $var1x = $_GET[$var1];
        $result = $dao::getById($var1x);

        if ($result) {
            http_response_code(200);
            echo json_encode([
                "status" => 200,
                "data" => $result
            ]);
        } else {
            http_response_code(404);
            echo json_encode([
                "status" => 404,
                "message" => "ID no existe"
            ]);
        }

    } elseif (isset($_GET[$var2])) {
        $var2x = $_GET[$var2];
        $result = $dao::getByValue($var2x);

        if ($result) {
            http_response_code(200);
            echo json_encode([
                "status" => 200,
                "data" => $result
            ]);
        } else {
            http_response_code(404);
            echo json_encode([
                "status" => 404,
                "message" => "No se encontraron coincidencias para el valor de búsqueda"
            ]);
        }

    } elseif (isset($_GET[$var3])) {
        $var3x = $_GET[$var3];
        $result = $dao::getByEspecialidad($var3x);

        if ($result) {
            echo json_encode([
                "status" => 1,
                "data" => $result
            ]);
        } else {
            echo json_encode([
                "status" => 2,
                "message" => "No se encontraron coincidencias para el valor de búsqueda"
            ]);
        }

    } else {
        $result = $dao::getAll();

        if ($result) {
            http_response_code(200);
            echo json_encode([
                "status" => 200,
                "data" => $result
            ]);
        } else {
            http_response_code(500);
            echo json_encode([
                "status" => 500,
                "message" => "Ha ocurrido un error"
            ]);
        }
    }
}

function handlePostRequest() {
    global $dao, $var1, $var2, $var3, $var4, $var5, $var6, $var7, $var8;
    $input = json_decode(file_get_contents('php://input'), true);

    if (isset($input[$var1]) && isset($input[$var2]) && isset($input[$var3]) && isset($input[$var4]) && isset($input[$var5]) && isset($input[$var6]) && isset($input[$var7]) && isset($input[$var8])) {
        $var1x = $input[$var1];
        $var2x = $input[$var2];
        $var3x = $input[$var3];
        $var4x = $input[$var4];
        $var5x = $input[$var5];
        $var6x = $input[$var6];
        $var7x = $input[$var7];
		$var8x = $input[$var8];

        if (!empty($dao::getById($var1x))) {
            $result = $dao::update($var1x, $var2x, $var3x, $var4x, $var5x, $var6x, $var7x, $var8x);

            if ($result) {
                http_response_code(200);
                echo json_encode([
                    "status" => 200,
                    "message" => "Actualización exitosa"
                ]);
            } else {
                http_response_code(500);
                echo json_encode([
                    "status" => 500,
                    "message" => "No se pudo actualizar"
                ]);
            }

        } else {
            $result = $dao::insert($var2x, $var3x, $var4x, $var5x, $var6x, $var7x, $var8x);

            if ($result) {
                http_response_code(201);
                echo json_encode([
                    "status" => 201,
                    "message" => "Inserción exitosa"
                ]);
            } else {
                http_response_code(500);
                echo json_encode([
                    "status" => 500,
                    "message" => "No se pudo insertar"
                ]);
            }
        }

    } else {
        http_response_code(400);
        echo json_encode([
            "status" => 400,
            "message" => "Datos incompletos"
        ]);
    }
}

function handleDeleteRequest() {
    global $dao, $var1;

    if (isset($_GET[$var1])) {
        $var1x = $_GET[$var1];

        if (!empty($dao::getById($var1x))) {
            $result = $dao::delete($var1x);

            if ($result) {
                http_response_code(200);
                echo json_encode([
                    "status" => 200,
                    "message" => "Eliminación exitosa"
                ]);
            } else {
                http_response_code(500);
                echo json_encode([
                    "status" => 500,
                    "message" => "No se pudo eliminar"
                ]);
            }

        } else {
            http_response_code(404);
            echo json_encode([
                "status" => 404,
                "message" => "ID no existe"
            ]);
        }

    } else {
        http_response_code(400);
        echo json_encode([
            "status" => 400,
            "message" => "ID no proporcionado"
        ]);
    }
}
?>
