<select id="OutputTarget" onchange="ChangeOutputTarget();">
              <option value="1">Dev</option>
              <option value="2">QA</option>
              <option value="3">Prod</option>
          </select>
            <div id="OutputFiles" style="height:300px;overflow:scroll">
                <ul id="OutputContent">
                </ul>
            </div>

<script>
    function getData(node)
    {

        var tree = [
            { "id": "1", "parent": "#", "text": "Stuff1", "type": "folder" },
            { "id": "200", "parent": "#", "text": "Stuff2", "type": "default" },
            { "id": "300", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "400", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "500", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "600", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "700", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "800", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "900", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "1000", "parent": "#", "text": "Stuff", "type": "default" },
            { "id": "1100", "parent": "200", "text": "Stuff*", "type": "default" },
            { "id": "1200", "parent": "200", "text": "Stuff*", "type": "default" },
            { "id": "1300", "parent": "500", "text": "Stuff", "type": "default" },
            { "id": "1400", "parent": "500", "text": "Stuff", "type": "default" },
            { "id": "2300", "parent": "1400", "text": "Stuff", "type": "default" },
            { "id": "3500", "parent": "1400", "text": "Stuff", "type": "default" },
            { "id": "3600", "parent": "1400", "text": "Stuff", "type": "default" },
            { "id": "3700", "parent": "1400", "text": "Stuff", "type": "default" }
        ];

        return tree;
    }

function ChangeOutputTarget()
{
    $('#OutputFiles')
        .jstree({
            "core" : {
                "animation": 0,
                "multiple": false,
                'data' : {
                    'data' : function (node) {
                        return getData(node);
                    }
                }
                ,
                "themes": { "stripes": false }
            },
            "plugins" : [ "types" ],
            "types" : {
                "default" : {
                    "icon" : "/images/file.png"
                },
                "file" : {
                    "icon" : "/images/file.png"
                },
                "folder" : {
                    "icon" : "/images/folder.png"
                }
            }
        });
}
</script>

Le dimanche 27 avril 2014 15:06:38 UTC-4, Ivan Bozhanov a écrit :
AJAX does not mean lazy load ... you can always supply all nodes in a single AJAX response - jstree will parse them and display them properly - take a look at the children property - make it an array and fill it with all of the nodes children. As for recreating the tree - it depends on your situation. You can either destroy the tree and create it anew with the new data, or refresh it and return the new data. For example:

.on("your-user-select-change", function () {
  $("#tree").jstree("destroy");
  $("#tree").jstree({ .. your config dependent on user selection .. })
});

Or if you want to only setup the tree once and have data or url or both change for the ajax request depending on your user selection:

$("#tree").jstree({ "core" : { "data" : {
  "url" : function () { if(user-selectable-condition-1) return "some-url"; else return "other-url"; },
  "data": function () { if(user-selectable-condition-1) return { "some" : "date" }; else return { "other" : "data"; },
 ...

.on("your-user-select-change", function () {
  $("#tree").jstree("refresh");

Since I do not know your situation you'd have to choose the method - it depends on how you get the data, and what the user event is ... but it should be pretty straightforward - either destroy the tree and create anew, or refresh the tree. Also - if it will be a dialog that would be destroyed and then recreated maybe it is best to destroy and recreate the tree too...

Best regards,
Ivan


27 април 2014, неделя, 21:38:10 UTC+3, Paul Dubé написа:
I am using jstree 3 and having a hard time finding the exact solution to my simple problem.

I wish to display a tree using an ajax load. The idea is that I need to display a tree based on a user selection on the page. So when the selection changes I have to reset the tree and display a different tree. I don't wish to have lazy-loading if I can avoid it, since my tree is usually not that big, so loading the complete tree would be the ideal solution.

As a final note, I already have a tree displayed on that page. The additional tree will be displayed inside a tab in a jquery dialog.

Can anyone give me an example how to accomplish that?

