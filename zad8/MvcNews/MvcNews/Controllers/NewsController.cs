using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MvcNews.Data;
using MvcNews.Models;

namespace MvcNews.Controllers
{
    public class NewsController : Controller
    {
        private readonly NewsDbContext _context;

        public NewsController(NewsDbContext context)
        {
            _context = context;
        }

        // GET: News
        public async Task<IActionResult> Index()
        {
            return View(await _context.News.ToListAsync());
        }

        // GET: News/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var newItem = await _context.News
                .FirstOrDefaultAsync(m => m.Id == id);
            if (newItem == null)
            {
                return NotFound();
            }

            return View(newItem);
        }

        // GET: News/Create
        public IActionResult Create()
        {
            NewItem item = new NewItem();
            item.TimeStamp = System.DateTime.Now;
            return View(item);
        }

        // POST: News/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,TimeStamp,Text")] NewItem newItem)
        {
            if (ModelState.IsValid)
            {
                _context.Add(newItem);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(newItem);
        }

        // GET: News/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var newItem = await _context.News.FindAsync(id);
            if (newItem == null)
            {
                return NotFound();
            }
            return View(newItem);
        }

        // POST: News/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,TimeStamp,Text,RowVersion")] NewItem newItem)
        {
            if (id != newItem.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(newItem);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!NewItemExists(newItem.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        ModelState.AddModelError("", "Error! Data has been modified by other user.");
                        return View(newItem);
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(newItem);
        }

        // GET: News/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var newItem = await _context.News
                .FirstOrDefaultAsync(m => m.Id == id);
            if (newItem == null)
            {
                return NotFound();
            }

            return View(newItem);
        }

        // POST: News/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var newItem = await _context.News.FindAsync(id);
            _context.News.Remove(newItem);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool NewItemExists(int id)
        {
            return _context.News.Any(e => e.Id == id);
        }
    }
}
