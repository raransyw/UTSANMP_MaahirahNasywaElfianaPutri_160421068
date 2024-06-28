<?php

$host = 'localhost';
$dbname = 'hobby';
$username = 'root';
$password = '';


$mysqli = new mysqli($host, $username, $password, $dbname);


if ($mysqli->connect_error) {
    die("Koneksi database gagal: " . $mysqli->connect_error);
}

$query = "SELECT news.*, users.username
FROM news
INNER JOIN users ON news.users_id = users.id;
";

$result = $mysqli->query($query);

$data = array();

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $data[] = $row;
    }
}


$mysqli->close();


$json_data = json_encode($data);


header('Content-Type: application/json');


echo $json_data;
?>