package br.ufma.sppg.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufma.sppg.model.Orientacao;

public interface OrientacaoRepository extends JpaRepository<Orientacao,Integer> {
  

    @Query("SELECT o FROM Orientacao o join Docente d join Programa p where p.id = :idPrograma and o.ano >= :anoInicio and o.ano <= :anoFim")
    List<Orientacao> findOrientacaoPPG(Integer idPrograma, Integer anoInicio, Integer anoFim);
    
    @Query("SELECT o FROM Orientacao o join Docente d where d.id = :idDocente and o.ano >= :anoInicio and o.ano <= :anoFim")
    List<Orientacao> findDocente(Integer idDocente, Integer anoInicio, Integer anoFim);

    
  

}
