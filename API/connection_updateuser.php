<?php
$koneksi = mysqli_connect("localhost", "root", "", "hobby");

if (mysqli_connect_errno()) {
    $response = array(
        'status' => 'error',
        'message' => 'Koneksi database gagal: ' . mysqli_connect_error()
    );
    echo json_encode($response);
    exit();
}

if ($_SERVER["REQUEST_METHOD"] == "GET") {
    if (!isset($_GET['id'])) {
        $response = array(
            'status' => 'error',
            'message' => 'ID pengguna tidak diberikan.'
        );
        echo json_encode($response);
        exit();
    }

$id = $_GET['id'];
$username = $_GET['username'];
$first_name = $_GET['first_name'];
$last_name = $_GET['last_name'];
$password = $_GET['password'];

if (empty($username) || empty($first_name) || empty($last_name) || empty($password)) {
    $response = array(
        'status' => 'error',
        'message' => 'Semua input diperlukan.'
    );
    echo json_encode($response);
    exit();
}

$query_update = "UPDATE users SET username='$username', first_name='$first_name', last_name='$last_name', password='$password' WHERE id=$id";
$result_update = mysqli_query($koneksi, $query_update);

        if ($result_update) {
            $response = array(
                'status' => 'success',
                'message' => 'Data pengguna berhasil diperbarui.'
            );
            echo json_encode($response);
        } else {
            $response = array(
                'status' => 'error',
                'message' => 'Gagal memperbarui data pengguna: ' . mysqli_error($koneksi)
            );
            echo json_encode($response);
        }
    } else {
        $response = array(
            'status' => 'error',
            'message' => 'Semua input diperlukan.'
        );
        echo json_encode($response);
    }
    exit(); 

mysqli_close($koneksi);
?>