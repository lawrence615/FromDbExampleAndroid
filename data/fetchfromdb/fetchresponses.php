<?php

require_once 'include/Connect.php';

function getResponses(){
	$db = new Connect();
	$db->connect();

	// array for json response
	$response = array();
	$response["allresponses"] = array();

	$results = mysql_query("SELECT * FROM responses");
	$no_of_rows = mysql_num_rows($results);

 	if ($no_of_rows > 0) {
	 	while ($row = mysql_fetch_array($results)) {
	 		$result["name"] = $row["name"];
	 		$result["phone"] = $row["phone"];
	 		$result["response"] = $row["response"];

	 		array_push($response["allresponses"], $result);
	 	}

 			// keeping response header to json
		header('Content-Type: application/json');

		// echoing json result
		echo json_encode($response);
	 } else{

	 }

}
getResponses();