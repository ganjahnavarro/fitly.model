package core.model.promo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.repository.AbstractRepository;

@Repository
@Transactional
public class PromoRepository extends AbstractRepository<Promo> {

	@SuppressWarnings("unchecked")
	public List<Promo> findFilteredItems(String filter,
			Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);
		
		if (filter != null && !filter.isEmpty()) {
			criteria.add(Restrictions.ilike("code", filter, MatchMode.START));
		}
		
		return criteria.list();
	}
	
	@Override
	protected String getEntityName() {
		return Promo.ENTITY_NAME;
	}

}
