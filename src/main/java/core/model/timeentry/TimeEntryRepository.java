package core.model.timeentry;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.repository.AbstractRepository;

@Repository
@Transactional
public class TimeEntryRepository extends AbstractRepository<TimeEntry> {

	@SuppressWarnings("unchecked")
	public List<TimeEntry> findFilteredItems(Long memberId, Long coachId,
			Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);
		
		if (memberId != null) {
			criteria.add(Restrictions.eq("member.id", memberId));
		}
		
		if (coachId != null) {
			criteria.add(Restrictions.eq("coachAssigned.id", coachId));
		}
		
		return criteria.list();
	}
	
	public TimeEntry findTimeEntryForDate(Long memberId, Date date) {
		Criteria criteria = getDefaultCriteria();
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.add(Restrictions.eq("date", date));
		return (TimeEntry) criteria.uniqueResult();
	}
	
	@Override
	protected String getEntityName() {
		return TimeEntry.ENTITY_NAME;
	}

}
