# Hibernate
hibernate demo project


basic
relation one to mane

bydefalt fetch type is LAZY

for second level cache we need to do the following
add dependency for ecahe(swarm etc),hibernaate-ecache
edit hibernate configuration
edit entity @cachable @cache

second level cache is aby default applicable for get only.
q.setCacheable(true);
<property name="hibernate.cache.use_query_cache">true</property>
