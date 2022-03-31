package me.Dex.ServiceMenu.Repository;

import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AdmissionDocRepository extends JpaRepository<AdmissionDoc, Long> {
    @Query(value = "select * from admission_doc where archived = false order by id", nativeQuery = true)
    public List<AdmissionDoc> getAllActive();

    @Query(value = "select * from admission_doc where archived = true order by id desc", nativeQuery = true)
    public List<AdmissionDoc> getAllArchived();

    @Transactional
    @Modifying
    @Query(value = "update admission_doc SET archived = ?2 where id = ?1", nativeQuery = true)
    public void setArchive(long id, boolean state);

}
