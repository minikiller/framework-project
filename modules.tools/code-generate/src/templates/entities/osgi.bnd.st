#-----------------------------------------------------------------
# Use this file to add customized Bnd instructions for the bundle
#-----------------------------------------------------------------

Bundle-Activator: ${bundle.namespace}.internal.InitActivator
Meta-Persistence: META-INF/persistence.xml
Import-Package:*
JPA-PersistenceUnits:<pomName>-cm
Bundle-Category: Rexen  <projectName> <beanName>