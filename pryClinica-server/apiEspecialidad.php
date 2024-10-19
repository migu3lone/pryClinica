<?php

/*$dao = 'daoEspecialidad';
$var1 = 'IdEspecialidad';
$var2 = 'Especialidad';*/

$dao = 'daoEspecialidad';
$var1 = 'var1';
$var2 = 'var2';

header('Content-Type: application/json');
require 'daoEspecialidad.php';
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
    global $dao, $var1, $var2;

    // Comprobar si se ha pasado el ID a través de la URL (por ejemplo, ?Id=valor)
    if (isset($_GET[$var1])) { // $_GET['Id'] // Si se pasa un ID
        $var1x = $_GET[$var1]; // $_GET['Id'] // Captura el valor del ID

    //if (isset($input[$var1])) {
    //    $var1x = $input[$var1];

        // Llamar a la función getById
        $result = $dao::getById($var1x);

        // Verificar si se encontró el resultado
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

    // Comprobar si se ha pasado otro valor de búsqueda, por ejemplo, ?search=valor
    } elseif (isset($_GET[$var2])) { // $_GET['Id'] // Si se pasa un valor de búsqueda (como 'nombre', 'fecha', etc.)
        $var2x = $_GET[$var2]; // $_GET['Id'] // Captura el valor de búsqueda

    //if (isset($input[$var1])) {
    //    $var1x = $input[$var1];

        // Llamar a la función getByValue
        $result = $dao::getByValue($var2x);

        // Verificar si se encontró el resultado
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

    // Si no se pasa ningún parámetro, obtener todos los registros
    } else {
        $result = $dao::getAll(); // Obtener todos los registros

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
    global $dao, $var1, $var2;
    $input = json_decode(file_get_contents('php://input'), true);

    if (isset($input[$var1]) && isset($input[$var2])) {
        $var1x = $input[$var1];
        $var2x = $input[$var2];

        // Verificar si existe el ID para decidir entre inserción o actualización
        if (!empty($dao::getById($var1x))) {
            // Si el ID existe, actualizar
            $result = $dao::update($var1x, $var2x);

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
            $result = $dao::insert($var2x);

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
        if (!empty($dao::getById($var1x))) {
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
