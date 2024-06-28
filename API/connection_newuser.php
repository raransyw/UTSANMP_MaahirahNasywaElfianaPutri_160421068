<?php

$koneksi = mysqli_connect("localhost", "root", "", "hobby");


if (mysqli_connect_errno()) {
    echo "Koneksi database gagal: " . mysqli_connect_error();
    exit();
}


$username = $_GET['username'];
$firstname = $_GET['first_name'];
$lastname = $_GET['last_name'];
$email = $_GET['email'];
$password = $_GET['password'];


$query = "INSERT INTO users (username, first_name, last_name, email, password) VALUES ('$username', '$firstname', '$lastname', '$email', '$password')";

if (mysqli_query($koneksi, $query)) {

    $response = array(
        'status' => 'success',
        'message' => 'User berhasil ditambahkan'
    );
    echo json_encode($response);
} else {
    
    $response = array(
        'status' => 'error',
        'message' => 'Gagal menambahkan user: ' . mysqli_error($koneksi)
    );
    echo json_encode($response);
}


mysqli_close($koneksi);
?>