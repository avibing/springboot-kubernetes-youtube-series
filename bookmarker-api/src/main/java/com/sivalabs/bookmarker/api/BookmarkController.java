package com.sivalabs.bookmarker.api;

import com.sivalabs.bookmarker.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping
    public BookmarksDTO getBookmarks(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "") String query) {
        if (query == null || query.trim().isEmpty()) {
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return bookmarkService.createBookmark(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO updateBookmark(@RequestBody @Valid UpdateBookmarkRequest request) {
        return bookmarkService.updateBookmark(request);
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBookmark(@RequestBody @Valid DeleteBookmarkRequest request) {
        return bookmarkService.deleteBookmark(request);
    }
}
