package model;

import java.util.Objects;

public class ContatoVO {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public ContatoVO(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public ContatoVO() {
    }

    public Integer getId() {
        return id;
    }

    public ContatoVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ContatoVO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContatoVO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public ContatoVO setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoVO contatoVO = (ContatoVO) o;
        return Objects.equals(nome, contatoVO.nome) && Objects.equals(email, contatoVO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email);
    }

    @Override
    public String toString() {
        return "ContatoVO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
