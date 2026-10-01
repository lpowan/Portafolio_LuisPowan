/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Portafolio_LuisPowan.service;

import Portafolio_LuisPowan.domain.Categoria;
import Portafolio_LuisPowan.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ltgpo
 */

@Service
public class CategoriaService {
    
        // El repositorio es final para asegurar la inmutabilidad
    private final CategoriaRepository categoriaRepository;

    // Inyeccion por constructor (no requiere @Autowired en Spring moderno)
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        if (activo) { //Solo activos...
            return categoriaRepository.findByActivoTrue();
        }
        return categoriaRepository.findAll();
    }
}