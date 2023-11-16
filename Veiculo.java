/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author gllbo
 */
public class Veiculo implements Serializable{
    private String numero;
    private String placa;
    private Usuario motorista;
    private String modelo;
    private Date datacompra;
    private Integer qtdpoltronas;
    
    public Veiculo() {
        
    }

    public Veiculo(String numero, String placa, Usuario motorista, String modelo, Date datacompra, Integer qtdpoltronas) {
        this.numero = numero;
        this.placa = placa;
        this.motorista = motorista;
        this.modelo = modelo;
        this.datacompra = datacompra;
        this.qtdpoltronas = qtdpoltronas;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Usuario getMotorista() {
        return motorista;
    }

    public void setMotorista(Usuario motorista) {
        this.motorista = motorista;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public Integer getQtdpoltronas() {
        return qtdpoltronas;
    }

    public void setQtdpoltronas(Integer qtdpoltronas) {
        this.qtdpoltronas = qtdpoltronas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numero);
        hash = 29 * hash + Objects.hashCode(this.placa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.placa, other.placa);
    }

    @Override
    public String toString() {
        return placa ;
    }


}
