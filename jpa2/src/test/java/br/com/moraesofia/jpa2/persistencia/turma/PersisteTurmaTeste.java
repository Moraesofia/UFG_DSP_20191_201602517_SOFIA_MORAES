package br.com.moraesofia.jpa2.persistencia.turma;

import br.com.gilmarioarantes.jpaexemplo.model.Aluno;
import br.com.gilmarioarantes.jpaexemplo.model.Turma;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PersisteTurmaTeste extends TurmaTeste{

    @Test
    public void persisteTurmaTest(){
        Turma turma = new Turma();
        turma.setSemestre("20191");
        turma.setDisciplina("Desenvolvimento de Software para Persistencia");
        List<Aluno> alunos = new ArrayList<>();
        Aluno a1 = new Aluno(2010003456L);
        Aluno a2 = new Aluno(2015004522L);
        Aluno a3 = new Aluno(2016001234L);
        Aluno a4 = new Aluno(2017004321L);
        Aluno a5 = new Aluno(2018007891L);
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);
        alunos.add(a5);
        turma.setAlunos(alunos);

        Turma novaTurma = dao.saveOrUpdate(turma);

        Assert.assertTrue(novaTurma.getAlunos().size() == 5);
    }
}
