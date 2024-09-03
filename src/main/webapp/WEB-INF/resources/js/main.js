function delCourse(path, id) {
    fetch(path, {
        method: "delete"
    }).then(res => {
        if (res.status === 204)
            location.reload();
        else {
            alert("Course have student (in enrollment)");
        }
    })
}