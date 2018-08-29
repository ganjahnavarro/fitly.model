package core.model.coach;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.repository.AbstractRepository;

@Repository
@Transactional
public class CoachRepository extends AbstractRepository<Coach> {

	@SuppressWarnings("unchecked")
	public List<Coach> findFilteredItems(String filter, Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);

		if (filter != null && !filter.isEmpty()) {
			criteria.add(Restrictions.ilike("firstName", filter, MatchMode.START));
		}
		List<Coach> list = criteria.list();
		return list;
	}

	@Override
	protected String getEntityName() {
		return Coach.ENTITY_NAME;
	}

}
