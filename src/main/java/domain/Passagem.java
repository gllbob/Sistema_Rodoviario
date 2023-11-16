package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Passagem implements Serializable {
    private Integer idpassagem;
    private Integer poltrona;
    private Date datasaida;
    private String horasaida;
    private Cidade cidadeorigem;
    private Cidade cidadedestino;
    private Double valorpassagem;
    private Usuario usuario;
    private Veiculo veiculo;
    
    public Passagem() {
   
}
    public Passagem(Integer idpassagem, Integer poltrona, Date datasaida, String horasaida, Cidade cidadeorigem, Cidade cidadedestino, double valorpassagem, Veiculo veiculo) {
    this.idpassagem = idpassagem;
    this.poltrona = poltrona;
    this.datasaida = datasaida;
    this.horasaida = horasaida;
    this.cidadeorigem = cidadeorigem;
    this.cidadedestino = cidadedestino;
    this.valorpassagem = valorpassagem;
    this.veiculo = veiculo;
}

    public Integer getIdpassagem() {
        return idpassagem;
    }

    public void setIdpassagem(Integer idpassagem) {
        this.idpassagem = idpassagem;
    }

    public Integer getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Integer poltrona) {
        this.poltrona = poltrona;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    public String getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(String horasaida) {
        this.horasaida = horasaida;
    }

    public Cidade getCidadeorigem() {
        return cidadeorigem;
    }

    public void setCidadeorigem(Cidade cidadeorigem) {
        this.cidadeorigem = cidadeorigem;
    }

    public Cidade getCidadedestino() {
        return cidadedestino;
    }

    public void setCidadedestino(Cidade cidadedestino) {
        this.cidadedestino = cidadedestino;
    }

    public Double getValorpassagem() {
        return valorpassagem;
    }

    public void setValorpassagem(Double valorpassagem) {
        this.valorpassagem = valorpassagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idpassagem);
        hash = 89 * hash + Objects.hashCode(this.poltrona);
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
        final Passagem other = (Passagem) obj;
        if (!Objects.equals(this.idpassagem, other.idpassagem)) {
            return false;
        }
        return Objects.equals(this.poltrona, other.poltrona);
    }
}
