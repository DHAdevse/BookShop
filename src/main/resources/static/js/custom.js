function toggleListbox(id) {
    var listbox = document.getElementById(id);
    if (listbox.classList.contains('show')) {
        listbox.classList.remove('show');
    } else {
        // Đóng tất cả các listbox khác
        var listboxes = document.getElementsByClassName('listbox');
        for (var i = 0; i < listboxes.length; i++) {
            listboxes[i].classList.remove('show');
        }
        // Mở listbox được chọn
        listbox.classList.add('show');
    }
}

// Đóng listbox khi click bên ngoài
document.addEventListener('click', function(event) {
    if (!event.target.closest('.category-nav') && !event.target.closest('.author-nav')) {
        var listboxes = document.getElementsByClassName('listbox');
        for (var i = 0; i < listboxes.length; i++) {
            listboxes[i].classList.remove('show');
        }
    }
});
