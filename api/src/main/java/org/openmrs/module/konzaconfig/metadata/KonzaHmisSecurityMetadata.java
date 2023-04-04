package org.openmrs.module.konzaconfig.metadata;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.stereotype.Component;
import org.openmrs.module.metadatadeploy.bundle.Requires;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

@Component
@Requires(org.openmrs.module.kenyaemr.metadata.SecurityMetadata.class)
public class KonzaHmisSecurityMetadata extends AbstractMetadataBundle {
	
	public static class _Privilege {
		
		public static final String APP_REG_APP = "App: konzaconfig.registration";
		
		public static final String APP_TRIAGE_APP = "App: konzaconfig.triage";
		
		public static final String APP_QUEUE_APP = "App: konzaconfig.queue";
		
		public static final String APP_OPD_APP = "App: konzaconfig.opd";
		
		public static final String APP_LAB_APP = "App: konzaconfig.lab";
		
		public static final String APP_IMAGING_APP = "App: konzaconfig.imaging";
		
		public static final String APP_PROCEDURE_APP = "App: konzaconfig.procedure";
	}
	
	public static final class _Role {
		
		public static final String APPLICATION_HMIS_MODULE = "Konza HMIS";
	}
	
	/**
	 * @see AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		install(privilege(_Privilege.APP_REG_APP, "Able to access Konza HMIS registration application"));
		install(privilege(_Privilege.APP_TRIAGE_APP, "Able to access Konza HMIS triage application"));
		install(privilege(_Privilege.APP_QUEUE_APP, "Able to access Konza HMIS queue application"));
		install(privilege(_Privilege.APP_OPD_APP, "Able to access Konza HMIS OPD application"));
		install(privilege(_Privilege.APP_LAB_APP, "Able to access Konza HMIS LAB application"));
		install(privilege(_Privilege.APP_IMAGING_APP, "Able to access Konza HMIS imaging application"));
		install(privilege(_Privilege.APP_PROCEDURE_APP, "Able to access Konza HMIS procedure application"));
		install(role(
		    _Role.APPLICATION_HMIS_MODULE,
		    "Can access Konza HMIS module application functionalities",
		    idSet(org.openmrs.module.kenyaemr.metadata.SecurityMetadata._Role.API_PRIVILEGES_VIEW_AND_EDIT),
		    idSet(_Privilege.APP_REG_APP, _Privilege.APP_TRIAGE_APP, _Privilege.APP_QUEUE_APP, _Privilege.APP_OPD_APP,
		        _Privilege.APP_LAB_APP, _Privilege.APP_IMAGING_APP, _Privilege.APP_PROCEDURE_APP)));
	}
}
