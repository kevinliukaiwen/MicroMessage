/**
 * Created by kevin on 2018/1/1.
 */

function deleteBatch(path) {
    $("#mainForm").attr("action", path);
    $("#mainForm").submit();
}