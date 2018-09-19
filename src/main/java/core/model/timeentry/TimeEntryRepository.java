package core.model.timeentry;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.model.coach.CoachEnrollees;
import core.report.SalesReport;
import core.repository.AbstractRepository;

@Repository
@Transactional
public class TimeEntryRepository extends AbstractRepository<TimeEntry> {

	@SuppressWarnings("unchecked")
	public List<TimeEntry> findFilteredItems(Long memberId, Long coachId, Date startDate, Date endDate,
			Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);
		
		if (memberId != null) {
			criteria.add(Restrictions.eq("member.id", memberId));
		}
		
		if (coachId != null) {
			criteria.add(Restrictions.eq("coachAssigned.id", coachId));
		}
		
		if (startDate != null) {
			criteria.add(Restrictions.ge("date", startDate));
		}
		
		if (endDate != null) {
			criteria.add(Restrictions.le("date", endDate));
		}
		
		return criteria.list();
	}
	
	public TimeEntry findTimeEntryForDate(Long memberId, Date date) {
		Criteria criteria = getDefaultCriteria();
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.add(Restrictions.eq("date", date));
		return (TimeEntry) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesReport> findSalesReport(Date startDate, Date endDate) {
		String queryString = "select "
				+ "new " + SalesReport.class.getName()
				+ "(o.date, o.coachAssigned, 'Commissions', o.commission) from "
				+ TimeEntry.ENTITY_NAME + " o where o.deleted = false"
				+ " and o.coachAssigned is not null";
		
		if (startDate != null) {
			queryString += " and o.date >= :startDate";
		}
		
		if (endDate != null) {
			queryString += " and o.date <= :endDate";
		}

		queryString += " order by o.date";
		Query query = getSession().createQuery(queryString);
		
		if (startDate != null) {
			query.setParameter("startDate", startDate);
		}
		
		if (endDate != null) {
			query.setParameter("endDate", endDate);
		}

		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<CoachEnrollees> findCoachEnrollees(Date startDate, Date endDate) {
		String queryString = "select "
				+ "new " + CoachEnrollees.class.getName()
				+ "(o.coachAssigned, count(o.id)) from "
				+ TimeEntry.ENTITY_NAME + " o where o.deleted = false"
				+ " and o.coachAssigned is not null";
		
		if (startDate != null) {
			queryString += " and o.date >= :startDate";
		}
		
		if (endDate != null) {
			queryString += " and o.date <= :endDate";
		}

		queryString += " group by o.coachAssigned order by count(o.id) desc";
		Query query = getSession().createQuery(queryString);
		
		if (startDate != null) {
			query.setParameter("startDate", startDate);
		}
		
		if (endDate != null) {
			query.setParameter("endDate", endDate);
		}

		return query.list();
	}
	
	@Override
	protected String getEntityName() {
		return TimeEntry.ENTITY_NAME;
	}

}
