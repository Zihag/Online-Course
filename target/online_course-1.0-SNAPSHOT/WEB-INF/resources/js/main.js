function delCourse(path, id) {
    fetch(path, {
        method: "DELETE"
    }).then(res => {
        if (res.status === 204) { //thanh cong
            location.reload();
        } else if (res.status === 409) { //loi
            alert("Course has students (in enrollment)"); //Lỗi do khoá ngoại ở bảng enrollment
        } else {
            alert("Failed. Try again."); //khác
        }
    }).catch(error => {
        console.error("Error:", error);
        alert("Error");
    });
}

function deleteExercise(path, id) {
    fetch(path, {
        method: "DELETE"
    }).then(res => {
        if (res.status === 204) { //thanh cong
            location.reload();
        } else if (res.status === 409) { //loi
            alert("STUDENT IS DOING EXERCISE!!!!"); //Lỗi do khoá ngoại ở bảng Submisison
        } else {
            alert("Failed. Try again."); //khác
        }
    }).catch(error => {
        console.error("Error:", error);
        alert("Error");
    });
}

function deleteTeacher(path, id) {
    fetch(path, {
        method: "DELETE"
    }).then(res => {
        if (res.status === 204) {
            location.reload(); // Xóa thành công, reload trang
        } else if (res.status === 409) { //loi
            alert("This teacher is IN COURSE!!!!"); //Lỗi do khoá ngoại ở course
        } else {
            alert("Failed. Try again."); //khác
        }
    }).catch(error => {
        console.error("Error:", error);
        alert("Error occurred while deleting the resource.");
    });
}

function deleteResource(path, id) {
    fetch(path, {
        method: "DELETE"
    }).then(res => {
        if (res.status === 204) {
            location.reload(); // Xóa thành công, reload trang
        } else {
            return res.text().then(text => {
                alert("Failed: " + text); // Hiển thị thông báo lỗi từ server
            });
        }
    }).catch(error => {
        console.error("Error:", error);
        alert("Error occurred while deleting the resource.");
    });
}

function deleteLecture(path, id) {
    fetch(path, {
        method: "DELETE"
    }).then(res => {
        if (res.status === 204) {
            location.reload(); // Xóa thành công, reload trang
        } else {
            return res.text().then(text => {
                alert("Failed: " + text); // Hiển thị thông báo lỗi từ server
            });
        }
    }).catch(error => {
        console.error("Error:", error);
        alert("Error occurred while deleting the resource.");
    });
}