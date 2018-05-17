package examples;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.AfterEach;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.BeforeEach;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Context;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Describe;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.It;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.JustBeforeEach;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.UUID;

import examples.models.Claim;
import examples.models.ClaimForm;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.content.fs.config.FilesystemStoreConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jConfiguration;
import com.github.paulcwarren.ginkgo4j.Ginkgo4jSpringRunner;

import examples.typesupport.UUIDBasedContentEntity;
import examples.typesupport.UUIDBasedContentEntityStore;

@RunWith(Ginkgo4jSpringRunner.class)
@Ginkgo4jConfiguration(threads=1)
@ContextConfiguration(classes = { EnableFilesystemStoresConfig.class })
public class ExamplesTest extends ContentStoreTests {

	@Autowired
	private File filesystemRoot;
	
	@Autowired
	private URIResourceStore store;
	
	@Autowired
	private DefaultConversionService filesystemStoreConverter;
	
	private Resource r;
	
	private Object contentEntity = null;
	
	private UUID id;
	
	@Autowired protected UUIDBasedContentEntityStore uuidStore;
	
	{
		Describe("Spring Content Filesystem", () -> {
			Describe("Storage Model", () -> {
				Describe("Default content placement", () -> {
					BeforeEach(() -> {
						claim = new Claim();
						claim.setFirstName("John");
						claim.setLastName("Smith");
						claim.setClaimForm(new ClaimForm());
						claim.getClaimForm().setContentId("12345");
						claimFormStore.setContent(claim.getClaimForm(), new ByteArrayInputStream("Hello Content World!".getBytes()));
						claimRepo.save(claim);
					});
					It("should store content in the root of the Store", () -> {
						assertThat(new File(Paths.get(filesystemRoot.getAbsolutePath(), claim.getClaimForm().getContentId()).toAbsolutePath().toString()).exists(), is(true));
					});
				});
				Describe("Custom content placement", () -> {
					Context("given a converter that converts a UUID id to a resource path", () -> {
						BeforeEach(() -> {
							filesystemStoreConverter.addConverter(new UUIDConverter());

							id = UUID.randomUUID();
							contentEntity = new UUIDBasedContentEntity();
							((UUIDBasedContentEntity)contentEntity).setContentId(id);
							uuidStore.setContent((UUIDBasedContentEntity)contentEntity, new ByteArrayInputStream("Hello Content World!".getBytes()));
						});
						AfterEach(() -> {
							filesystemStoreConverter.removeConvertible(UUID.class, String.class);
						});
						It("should store content at that path", () -> {
							String[] segments = id.toString().split("-");
							
							assertThat(new File(Paths.get(filesystemRoot.getAbsolutePath(), segments).toAbsolutePath().toString()).exists(), is(true));
						});
					});
				});
			});
			
			Describe("Store API (Experimental)", () -> {
				Describe("Store", () -> {
					Context("given a uri-based resource store", () -> {
						Context("given an existing resource", () -> {
							BeforeEach(() -> {
								// write some content in the old placement location (store root) 
								// and create a entity so we can try and fetch it
								File file = new File(Paths.get(filesystemRoot.getAbsolutePath(), "some", "thing").toAbsolutePath().toString());
								file.getParentFile().mkdirs();
								FileOutputStream out = new FileOutputStream(file);
								out.write("Hello Spring Content World!".getBytes());
								out.close();
							});
							JustBeforeEach(() -> {
								r = store.getResource("/some/thing");
							});
							AfterEach(() -> {
								FileUtils.forceDelete(new File(Paths.get(filesystemRoot.getAbsolutePath(), "some", "thing").toAbsolutePath().toString()));
							});
							It("should be able to get that resource", () -> {
								assertThat(IOUtils.contentEquals(r.getInputStream(), IOUtils.toInputStream("Hello Spring Content World!", Charset.defaultCharset())), is(true));
							});
						});
					});
				});
				Describe("AssociativeStore", () -> {
					Context("given an entity", () -> {
						BeforeEach(() -> {
							claim = new Claim();
							claim.setClaimForm(new ClaimForm());
						});
						Context("given a resource", () -> {
							BeforeEach(() -> {
								// write some content in the old placement location (store root) 
								// and create a entity so we can try and fetch it
								File file = new File(Paths.get(filesystemRoot.getAbsolutePath(), "some", "other", "thing").toAbsolutePath().toString());
								file.getParentFile().mkdirs();
								FileOutputStream out = new FileOutputStream(file);
								out.write("Hello Spring Content World!".getBytes());
								out.close();

								r = store.getResource("/some/other/thing");
							});
							AfterEach(() -> {
								FileUtils.forceDelete(new File(Paths.get(filesystemRoot.getAbsolutePath(), "some", "other", "thing").toAbsolutePath().toString()));
							});
							Context("when it is associated", () -> {
								BeforeEach(() -> {
									store.associate(claim.getClaimForm(), "/some/other/thing");
								});
								It("should update the entity's content attributes", () -> {
									assertThat(claim.getClaimForm().getContentId(), is("/some/other/thing"));
									assertThat(claim.getClaimForm().getContentLength(), is(27L));
								});
							});
							Context("given it is associated", () -> {
								BeforeEach(() -> {
									store.associate(claim.getClaimForm(), "/some/other/thing");
								});
								Context("when it is unassociated", () -> {
									BeforeEach(() -> {
										store.unassociate(claim.getClaimForm());
									});
									It("should reset the entity's content attributes", () -> {
										assertThat(claim.getClaimForm().getContentId(), is(nullValue()));
										assertThat(claim.getClaimForm().getContentLength(), is(0L));
									});
								});
							});
						});
					});
				});
			});
		}); 
	}
	
	public class UUIDConverter implements FilesystemStoreConverter<UUID,String> {
		@Override
		public String convert(UUID source) {
			return String.format("/%s", source.toString().replaceAll("-","/"));
		}
	}
	
}
