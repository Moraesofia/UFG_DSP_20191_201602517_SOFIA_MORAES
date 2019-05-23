package br.com.moraesofia.jpa2;

import br.com.moraesofia.jpa2.model.Abrigo;
import br.com.moraesofia.jpa2.model.Cachorro;
import br.com.moraesofia.jpa2.model.Endereco;
import br.com.moraesofia.jpa2.model.Voluntario;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DaoGenerico dao = new DaoGenerico();

        Abrigo a = new Abrigo();
        Abrigo b = new Abrigo();
        List<Abrigo> abrigos = new ArrayList<>();

        dao.saveOrUpdate(a);
        dao.saveOrUpdate(b);

        Cachorro cao1 = new Cachorro();
        cao1.setNome("Dag");
        cao1.setAbrigo(a);

        Cachorro cao2 = new Cachorro();
        cao2.setNome("Lion");
        cao1.setAbrigo(a);

        List<Cachorro> caos1 = new ArrayList<>(); // Abrigo A
        caos1.add(cao1);
        caos1.add(cao2);

        dao.saveOrUpdate(cao1);
        dao.saveOrUpdate(cao2);

        Cachorro cao3 = new Cachorro();
        cao1.setNome("Milu");
        cao1.setAbrigo(b);

        Cachorro cao4 = new Cachorro();
        cao2.setNome("Bil");
        cao1.setAbrigo(b);

        List<Cachorro> caos2 = new ArrayList<>(); // Abrigo B
        caos2.add(cao3);
        caos2.add(cao4);

        dao.saveOrUpdate(cao3);
        dao.saveOrUpdate(cao4);

        Endereco end1 = new Endereco(); //Abrigo A
        end1.setBairro("Samambaia");
        end1.setNumero(1);
        end1.setRua("aroeira");
        end1.setAbrigo(a);

        Endereco end2 = new Endereco(); // Abrigo B
        end2.setBairro("Universitario");
        end2.setNumero(1);
        end2.setRua("baru");
        end2.setAbrigo(b);

        dao.saveOrUpdate(end1);
        dao.saveOrUpdate(end2);

        Voluntario vol1 = new Voluntario();
        vol1.setCpf(11);
        vol1.setNome("Jonas");
        vol1.setAbrigosQueTrabalha(abrigos);

        Voluntario vol2 = new Voluntario();
        vol2.setCpf(69);
        vol2.setNome("Neosoro");
        vol2.setAbrigosQueTrabalha(abrigos);

        List<Voluntario> vols = new ArrayList<>();
        vols.add(vol1);
        vols.add(vol2);

        dao.saveOrUpdate(vol1);
        dao.saveOrUpdate(vol2);

        a.setCachorros(caos1);
        a.setEndereco(end1);
        a.setVoluntarios(vols);

        b.setCachorros(caos2);
        b.setEndereco(end2);
        b.setVoluntarios(vols);

        dao.saveOrUpdate(a);
        dao.saveOrUpdate(b);

        System.out.println(dao.findById(Abrigo.class, 1L).getId());

    }
}
