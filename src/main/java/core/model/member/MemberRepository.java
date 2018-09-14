package core.model.member;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.enums.MemberType;
import core.repository.AbstractRepository;

@Repository
@Transactional
public class MemberRepository extends AbstractRepository<Member> {
	
	@SuppressWarnings("unchecked")
	public Long findCount(MemberType type) {
		Criteria criteria = getDefaultCriteria();

		type = type == null ? MemberType.REGULAR : type;
		criteria.add(Restrictions.eq("type", type));

		List<Member> list = criteria.list();
		return list != null ? Long.valueOf(list.size()) : 0;
	}

	@SuppressWarnings("unchecked")
	public List<Member> findFilteredItems(MemberType type, String filter, Integer pageSize, Integer pageOffset, String orderBy) {
		Criteria criteria = getPagedItemsCriteria(pageSize, pageOffset, orderBy);

		if (filter != null && !filter.isEmpty()) {
			criteria.add(Restrictions.ilike("firstName", filter, MatchMode.START));
		}
		
		if (type != null) {
			criteria.add(Restrictions.eq("type", type));
		}

		List<Member> list = criteria.list();
		return list;
	}
	
	public Member findByAccessCardNo(String accessCardNo) {
		Criteria criteria = getSession().createCriteria(Membership.class);
		criteria.add(Restrictions.eq("accessCardNo", accessCardNo));
		Membership membership = (Membership) criteria.uniqueResult();
		
		return membership != null ? membership.getMember() : null;
	}
	
	@Override
	protected String getEntityName() {
		return Member.ENTITY_NAME;
	}

}
