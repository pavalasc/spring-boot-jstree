package ro.procont.jspringjstree.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.procont.jspringjstree.model.Asset;


@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {


}
