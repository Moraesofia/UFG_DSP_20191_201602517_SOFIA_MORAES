package br.com.Moraesofia.aula2528jpa.persistencia;

import br.com.Moraesofia.aula2528jpa.model.Veiculo;

public interface VeiculoRepository {
    /**
     * Create a new Person
     *
     * @param Veiculo
     * @return Person
     */
    Veiculo create(Veiculo veiculo);

    /**
     * Read Person by id
     *
     * @param id
     * @return Veiculo
     */
    Veiculo read(Long id);

    /**
     *
     * @param name
     * @return
     */
    // List<Veiculo> findByName(String name);

    /**
     * Update person
     *
     * @param Veiculo
     */
    Veiculo update(Veiculo veiculo);

    /**
     * Delete person
     *
     * @param Veiculo
     */
    void delete(Veiculo veiculo);

    /**
     * close the model manager factory
     */
    void close();

}
