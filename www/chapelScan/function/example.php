<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 9/20/2017
 * Time: 4:23 PM
 */

class example {
    var $name;

    //constructor
    function __construct($persons_name) {
        $this->name = $persons_name;
    }

    //setter
    function set_name($new_name) {
        $this->name = $new_name;
    }

    //getter
    function get_name() {
        return $this->name;
    }
}