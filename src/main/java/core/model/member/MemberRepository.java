package core.model.member;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.repository.AbstractRepository;

@Repository
@Transactional
public class MemberRepository extends AbstractRepository<Member> {

	@SuppressWarnings("unchecked")
	public List<Member> findFilteredItems(String filter, Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);

		if (filter != null && !filter.isEmpty()) {
			criteria.add(Restrictions.ilike("firstName", filter, MatchMode.START));
		}
		List<Member> list = criteria.list();
		return list;
	}

	@Override
	protected String getEntityName() {
		return Member.ENTITY_NAME;
	}

}
