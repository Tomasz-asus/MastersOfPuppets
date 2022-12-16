package com.example.mastersofpuppets.Exception;

public class NameAlreadyExist extends RuntimeException{

    public NameAlreadyExist(){
         super("Name already exist");
    }
}
