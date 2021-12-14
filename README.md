# Ignite-persistent-cache-example
Example project how values persist in ingnite cache and stored on disk and persist even after node restart



add below peroperty to enable persistance in example-ignite.xml

 <bean id="ignite.cfg" class="org.apache.ignite.configuration.IgniteConfiguration">
        <!-- Enabling Apache Ignite Persistent Store. -->
        <property name="dataStorageConfiguration">
            <bean class="org.apache.ignite.configuration.DataStorageConfiguration">
                <property name="defaultDataRegionConfiguration">
                    <bean class="org.apache.ignite.configuration.DataRegionConfiguration">
                        <property name="persistenceEnabled" value="true"/>
                    </bean>
                </property>
            </bean>
        </property>
		</bean>
