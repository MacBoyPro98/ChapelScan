<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 1/30/2019
 * Time: 3:37 PM
 */


class Queue extends Node {
    /* Member variables */
    private $head;
    private $tail;
    private $length;

    function __construct() {
        $this->head = null;
        $this->tail = null;
        $this->length = 0;
    }
    /* Methods */
    // Returns if the array is empty
    public function isEmpty() {
        if ($this->length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public function getLength() {
        if ($this->head == null) {
            $this->length = 0;
        }
    }

    //Pushes new item onto the queue
    public function push() {

    }

    public function pop() {

    }
}