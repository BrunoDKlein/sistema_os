/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kelvin
 */
public class Cliente {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email; 
    public Cliente(){
    
}
    public Cliente(String nome, String endereco, String telefone, String email, String linkedin) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
      
    }
}
