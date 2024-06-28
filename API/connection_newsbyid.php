<?php

$host = 'localhost';
$dbname = 'hobby';
$username = 'root';
$password = '';


$id = $_GET['id']; 


$mysqli = new mysqli($host, $username, $password, $dbname);


if ($mysqli->connect_error) {
    die("Koneksi database gagal: " . $mysqli->connect_error);
}


$query = "SELECT news.*, users.username
FROM news
INNER JOIN users ON news.users_id = users.id
WHERE news.id = $id;
";


$result = $mysqli->query($query);


$news = array();


if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $news = $row;
    }
}


$mysqli->close();


$json_berita = json_encode($news);


header('Content-Type: application/json');

echo $json_berita;
?>