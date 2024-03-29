package core.model.pkg;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.repository.AbstractRepository;

@Repository
@Transactional
public class PackageRepository extends AbstractRepository<Package> {

	@SuppressWarnings("unchecked")
	public List<Package> findFilteredItems(String filter, Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);

		if (filter != null && !filter.isEmpty()) {
			criteria.add(Restrictions.ilike("name", filter, MatchMode.START));
		}
		List<Package> list = criteria.list();
		return list;
	}
	
	@Override
	protected String getEntityName() {
		return Package.ENTITY_NAME;
	}

}
