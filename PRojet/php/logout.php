<?php
session_start();
session_destroy();
header("Location: /PRojet/index.html");
exit();
?>
