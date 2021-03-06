package com.lhw.cafe.member;

import java.util.List;

public interface MemberMapper {
		public abstract int join(Member m);
		public abstract Member getMemberById(Member m);
		public abstract int update(Member m);
		public abstract int bye(Member m);
		public abstract List<Member> getMemberById2(Member m);
}
