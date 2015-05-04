<!DOCTYPE html>
<html lang="en">
<#include "header.ftl">
<body role="document">

<div class="container">

    <div class="sixteen columns">
        <h2>MarkLogic ErrorLog Analyser <small>Upload</small></h2>
    <#include "navigation.ftl">
    </div>

    <!-- h1>MarkLogic PStack Tools : Upload PStack Movie</h1>
    <h2>Choose a PStack Movie file to process:</h2 -->


    <div class="panel panel-default">
        <div class="panel-heading"><strong>Upload Files</strong> <small>Bootstrap files upload</small></div>
        <div class="panel-body">

            <h4>Select files from your computer</h4>
            <form enctype="multipart/form-data" action="/upload" method="post" class="dropzone" id="file-dropzone"></form>

        </div>
    </div>

</div>
<#include "footer.ftl">
</body>
</html>



