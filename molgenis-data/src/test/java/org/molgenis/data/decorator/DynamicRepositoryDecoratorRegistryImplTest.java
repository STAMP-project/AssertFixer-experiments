package org.molgenis.data.decorator;

import com.google.gson.Gson;
import org.mockito.Mock;
import org.molgenis.data.*;
import org.molgenis.data.decorator.meta.*;
import org.molgenis.data.event.BootstrappingEvent;
import org.molgenis.data.meta.model.EntityType;
import org.molgenis.data.support.QueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.molgenis.data.decorator.meta.DecoratorConfigurationMetadata.DECORATOR_CONFIGURATION;
import static org.molgenis.data.decorator.meta.DecoratorConfigurationMetadata.ENTITY_TYPE_ID;
import static org.molgenis.data.event.BootstrappingEvent.BootstrappingStatus.FINISHED;
import static org.testng.Assert.assertEquals;

@ContextConfiguration(classes = { DecoratorConfigurationMetadata.class, DecoratorPackage.class,
		DynamicDecoratorMetadata.class, DecoratorParametersMetadata.class })
public class DynamicRepositoryDecoratorRegistryImplTest extends AbstractMolgenisSpringTest
{
	@Autowired
	DecoratorConfigurationMetadata decoratorConfigurationMetadata;

	@Autowired
	DecoratorParametersMetadata decoratorParametersMetadata;

	@Mock
	private Repository<Entity> repository;
	@Mock
	private DataService dataService;
	@Mock
	private EntityType entityType;
	@Mock
	private DecoratorConfiguration decoratorConfiguration;
	@Mock
	private DynamicRepositoryDecoratorFactory<Entity> dynamicRepositoryDecoratorFactory;
	private DynamicRepositoryDecoratorRegistryImpl dynamicRepositoryDecoratorRegistry;

	@BeforeMethod
	public void beforeMethod()
	{
		dynamicRepositoryDecoratorRegistry = new DynamicRepositoryDecoratorRegistryImpl(dataService, new Gson());

		//fake the bootstrapping event to tell the registry that bootstrapping is finished.
		dynamicRepositoryDecoratorRegistry.onApplicationEvent(new BootstrappingEvent(FINISHED));

		when(entityType.getId()).thenReturn("entityTypeId");
		when(repository.getEntityType()).thenReturn(entityType);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testDecorate()
	{
		DynamicDecorator dynamicDecorator = mock(DynamicDecorator.class);
		DecoratorParameters parameters = mock(DecoratorParameters.class);
		Repository<Entity> decoratedRepository = mock(Repository.class);

		when(decoratedRepository.getName()).thenReturn("decoratedRepositoryName");
		when(decoratorConfiguration.getDecoratorParameters()).thenReturn(Stream.of(parameters));
		when(dynamicDecorator.getId()).thenReturn("dynamicDecoratorId");

		when(dynamicRepositoryDecoratorFactory.getId()).thenReturn("dynamicDecoratorId");
		when(dynamicRepositoryDecoratorFactory.createDecoratedRepository(repository, mock(Map.class))).thenReturn(
				decoratedRepository);
		Query<DecoratorConfiguration> query = new QueryImpl<>();
		query.eq(ENTITY_TYPE_ID, "entityTypeId");
		when(dataService.findOne(DECORATOR_CONFIGURATION, query, DecoratorConfiguration.class)).thenReturn(
				decoratorConfiguration);

		dynamicRepositoryDecoratorRegistry.addFactory(dynamicRepositoryDecoratorFactory);

		assertEquals(dynamicRepositoryDecoratorRegistry.decorate(repository).getName(), "decoratedRepositoryName");
	}

	@Test
	public void testDecorateNoDecorator()
	{
		when(repository.getEntityType()).thenReturn(entityType);
		when(repository.getName()).thenReturn("repositoryName");
		when(entityType.getId()).thenReturn("entityTypeId");

		assertEquals(dynamicRepositoryDecoratorRegistry.decorate(repository).getName(), "repositoryName");
	}
}