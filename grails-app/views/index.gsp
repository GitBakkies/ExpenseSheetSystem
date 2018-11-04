<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Expense Sheet System</title>
</head>
<body>
    %{--<content tag="nav">--}%
        %{--<li class="dropdown">--}%
            %{--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>--}%
            %{--<ul class="dropdown-menu">--}%
                %{--<li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>--}%
                %{--<li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>--}%
                %{--<li><a href="#">App version:--}%
                    %{--<g:meta name="info.app.version"/></a>--}%
                %{--</li>--}%
                %{--<li role="separator" class="divider"></li>--}%
                %{--<li><a href="#">Grails version:--}%
                    %{--<g:meta name="info.app.grailsVersion"/></a>--}%
                %{--</li>--}%
                %{--<li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>--}%
                %{--<li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>--}%
                %{--<li role="separator" class="divider"></li>--}%
                %{--<li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>--}%
            %{--</ul>--}%
        %{--</li>--}%
        %{--<li class="dropdown">--}%
            %{--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>--}%
            %{--<ul class="dropdown-menu">--}%
                %{--<li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>--}%
                %{--<li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>--}%
                %{--<li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>--}%
                %{--<li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>--}%
            %{--</ul>--}%
        %{--</li>--}%
        %{--<li class="dropdown">--}%
            %{--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>--}%
            %{--<ul class="dropdown-menu">--}%
                %{--<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">--}%
                    %{--<li><a href="#">${plugin.name} - ${plugin.version}</a></li>--}%
                %{--</g:each>--}%
            %{--</ul>--}%
        %{--</li>--}%
    %{--</content>--}%

    <div class="svg" role="presentation">
        <div class="grails-logo-container">
            <asset:image src="expense sheet system.png" class="ESS-logo"/>
        </div>
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Expense Sheet System</h1>

            <p>
                Welcome to ESS
            </p>

            <div id="controllers" role="navigation">
                <h2>Menu:</h2>
                <ul>
                    %{--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">--}%
                        %{--<li class="controller">--}%
                            %{--<g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>--}%
                        %{--</li>--}%
                    %{--</g:each>--}%


                    <li class="controller">
                        <a href="/person/index">Manage Persons</a>
                    </li>

                    <li class="controller">
                        <a href="/transactions/index">Manage Transactions</a>
                    </li>

                    <li class="controller">
                        <a href="/csvDownload/index">Download CSV</a>
                    </li>
                </ul>
            </div>
        </section>
    </div>

</body>
</html>
