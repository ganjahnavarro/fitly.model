package core.model.timeentry;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.repository.AbstractRepository;

@Repository
@Transactional
public class TimeEntryRepository extends AbstractRepository<TimeEntry> {

	@SuppressWarnings("unchecked")
	public List<TimeEntry> findFilteredItems(Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);
		return criteria.list();
	}
	
	@Override
	protected String getEntityName() {
		return TimeEntry.ENTITY_NAME;
	}

}
