package tool;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MapperUtil {
	private static SqlSessionFactory sf;
	static {
		InputStream is = null;
		try {
			is = Resources
					.getResourceAsStream("idv/fc/mybatis/mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		sf = sfb.build(is);

	}

	private static <T> SessionBuilder<T> getSessionBuilder() {
		return new SessionBuilder<>();
	}

	public static <T> SessionBuilder<T> setMapperType(Class<T> mapperType) {
		SessionBuilder<T> builder = getSessionBuilder();
		builder.setMapperType(mapperType);
		return builder;
	}

	public static <T> T getMapper(Class<T> mapperType) {
		SqlSession openSession = sf.openSession();
		return openSession.getMapper(mapperType);
	}

	public static class SessionBuilder<T> {
		private boolean autoCommit = false;
		private Class<T> mapperType;

		public SessionBuilder<T> setMapperType(Class<T> mapperType) {
			this.mapperType = mapperType;
			return this;
		}

		public SessionBuilder<T> setAutoCommit() {
			this.autoCommit = true;
			return this;
		}

		public T getMapper() {
			return sf.openSession(this.autoCommit).getMapper(mapperType);
		}

	}

}
