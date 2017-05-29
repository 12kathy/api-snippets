<?php
require_once './vendor/autoload.php';
use Twilio\Twiml;

$response = new Twiml();
$gather = $response->gather(['method' => 'GET',
    'action' => '/process_gather.php']);
$gather->say('Enter something, or not');
$response->redirect('/process_gather.php?Digits=TIMEOUT', ['method' => 'GET']);

echo $response;
